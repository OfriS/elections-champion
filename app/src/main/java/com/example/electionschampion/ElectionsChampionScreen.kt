package com.example.electionschampion

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.electionschampion.ui.GameViewModel
import com.example.electionschampion.ui.screens.GameOverScreen
import com.example.electionschampion.ui.screens.GameScreen
import com.example.electionschampion.ui.screens.ModeSelectionScreen

enum class ElectionsChampionScreen() {
    ModeSelection,
    Game,
    GameOver,
}

/**
 * Displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElectionsChampionAppBar(
    currentScreen: ElectionsChampionScreen,
    navigateToHomeScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(R.string.top_bar_text)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (currentScreen == ElectionsChampionScreen.Game) {
                IconButton(onClick = navigateToHomeScreen) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun currentScreen(navController: NavController): ElectionsChampionScreen {
    // Observe the current back stack entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Get the route of the current destination
    val currentRoute = navBackStackEntry?.destination?.route

    return currentRoute?.let { ElectionsChampionScreen.valueOf(it) }
        ?: ElectionsChampionScreen.ModeSelection
}

@Composable
fun ElectionsChampionApp(
    viewModel: GameViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            ElectionsChampionAppBar(
                currentScreen = currentScreen(navController = navController),
                navigateToHomeScreen = { navController.navigate(ElectionsChampionScreen.ModeSelection.name) },
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        viewModel.initializeApp(LocalContext.current.assets.open("results_25.csv"))

        NavHost(
            navController = navController,
            startDestination = ElectionsChampionScreen.ModeSelection.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            // Allow the user to select game-mode and then initialize the game.
            composable(route = ElectionsChampionScreen.ModeSelection.name) {
                ModeSelectionScreen(
                    modifier = Modifier.fillMaxSize(),
                    onStartButtonClicked = {
                        viewModel.initializeGame()
                        navController.navigate(ElectionsChampionScreen.Game.name)
                    },
                    currentDifficulty = uiState.difficulty,
                    onDifficultyButtonClicked = viewModel::changeDifficulty,
                    currentPlayingAsParty = uiState.playingAsParty,
                    onPartyButtonClicked = viewModel::changePlayingAsParty,
                )
            }

            // Run the game until the user fails.
            composable(route = ElectionsChampionScreen.Game.name) {
                GameScreen(
                    modifier = Modifier
                        .fillMaxSize(),
                    onClickMore = {
                        if (!viewModel.displayedIsMore()) {
                            viewModel.onCorrectGuess()
                        } else {
                            navController.navigate(ElectionsChampionScreen.GameOver.name)
                        }
                    },
                    onClickLess = {
                        if (viewModel.displayedIsMore()) {
                            viewModel.onCorrectGuess()
                        } else {
                            navController.navigate(ElectionsChampionScreen.GameOver.name)
                        }
                    },
                    state = uiState,
                )
            }

            // Display the player's final score and allow them to reset the game.
            composable(route = ElectionsChampionScreen.GameOver.name) {
                GameOverScreen(
                    modifier = Modifier
                        .fillMaxSize(),
                    onRestartButtonClicked = {
                        navController.navigate(ElectionsChampionScreen.ModeSelection.name)
                    },
                    score = uiState.score,
                )
            }
        }
    }
}

@Preview
@Composable
private fun A() {
    ElectionsChampionApp()
}