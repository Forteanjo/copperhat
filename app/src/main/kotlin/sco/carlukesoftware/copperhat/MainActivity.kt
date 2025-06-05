package sco.carlukesoftware.copperhat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sco.carlukesoftware.copperhat.ui.components.CopperHat
import sco.carlukesoftware.copperhat.ui.components.FedoraHat
import sco.carlukesoftware.copperhat.ui.theme.CopperHatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CopperHatTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        CopperHat(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(fraction = 1/3f)
                                .weight(1f),
                            zoomFactor = 2f
                        )

                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                                .weight(1f)
                        )

                        FedoraHat(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(fraction = 1/3f)
                                .weight(1f),
                            zoomFactor = 1f
                        )

                    }
                }
            }
        }
    }
}
