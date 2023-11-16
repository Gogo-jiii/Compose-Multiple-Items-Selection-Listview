package com.example.multipleitemsselectionlistview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multipleitemsselectionlistview.ui.theme.MultipleItemsSelectionListViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleItemsSelectionListViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    val list = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z"
    )

    val dataList = remember { mutableStateListOf(MyDataClass("", false)) }

    loadData(list, dataList)

    LazyColumn(
        content = {
            items(count = list.size) { index ->
                Box(
                    modifier = Modifier
                        .clickable {
                            val isSelectedValue = dataList[index].isSelected
                            dataList[index] = dataList[index].copy(isSelected = !isSelectedValue)
                        }
                        .background(color = if (dataList[index].isSelected) Color.Blue else Color.White)
                )
                {
                    Text(
                        text = list[index],
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 16.dp),
                        color = if (dataList[index].isSelected) Color.White else Color.Black
                    )
                    Divider(thickness = 8.dp, color = Color.DarkGray)
                }
            }
        },
        userScrollEnabled = true,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
}

fun loadData(list: List<String>, dataList: SnapshotStateList<MyDataClass>) {
    dataList.clear()
    for (item in list) {
        dataList.add(MyDataClass(name = item, isSelected = false))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MultipleItemsSelectionListViewTheme {
        Greeting()
    }
}