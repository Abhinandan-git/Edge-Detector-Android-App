package net.abhinandan.edge_detector_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.abhinandan.edge_detector_android_app.ui.theme.EdgeDetectorAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EdgeDetectorAndroidAppTheme {

            }
        }
    }
}
