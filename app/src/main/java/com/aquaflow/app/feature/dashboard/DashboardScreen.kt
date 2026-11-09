package com.aquaflow.app.feature.dashboard
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Undo
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aquaflow.app.core.design.theme.Aqua
import com.aquaflow.app.core.design.theme.Ice
import com.aquaflow.app.core.design.theme.Midnight
import java.util.Locale

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel()) {
    val intake by viewModel.totalIntake.collectAsState()
    val currentIntake = intake ?: 0
    val goal = 2500
    val progress = (currentIntake.toFloat() / goal).coerceIn(0f, 1f)

    Column(
        modifier = Modifier.fillMaxSize().background(Midnight).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("AQUAFLOW", color = Ice, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(48.dp))

        // Circular Progress
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(240.dp),
                color = Aqua,
                trackColor = Color.DarkGray,
                strokeWidth = 12.dp
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$currentIntake", color = Color.White, fontSize = 48.sp, fontWeight = FontWeight.Bold)
                Text(text = "of $goal ml", color = Color.Gray, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Add Water Button
        Button(
            onClick = { viewModel.addWater(250) },
            modifier = Modifier.fillMaxWidth().height(64.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Aqua),
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = null, tint = Midnight)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add 250 ml", color = Midnight, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        // Undo Button
        TextButton(onClick = { viewModel.undo() }) {
            Icon(Icons.Default.Undo, contentDescription = null, tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Undo Last", color = Color.Gray)
        }
    }
}
