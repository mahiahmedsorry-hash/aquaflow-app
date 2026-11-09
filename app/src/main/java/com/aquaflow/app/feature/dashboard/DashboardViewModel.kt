package com.aquaflow.app.feature.dashboard
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aquaflow.app.data.local.AquaflowDatabase
import com.aquaflow.app.data.local.WaterEntry
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DashboardViewModel(app: Application) : AndroidViewModel(app) {
    private val db = AquaflowDatabase.getDatabase(app)
    private val dao = db.waterDao()
    private val dailyGoal = 2500 // Phase 2 এ আপাতত ফিক্সড রাখা হলো

    val totalIntake = dao.getTotalWaterToday().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )

    fun addWater(amount: Int) {
        viewModelScope.launch {
            dao.insertWater(WaterEntry(amountMl = amount))
        }
    }
    
    fun undo() {
        viewModelScope.launch {
            dao.undoLastEntry()
        }
    }
}
