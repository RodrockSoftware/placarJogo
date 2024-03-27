package com.example.jogodoslindos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScoreboardApp()
        }
        }
}

@Composable
fun ScoreboardApp() {
    var scoreTeamA by remember { mutableIntStateOf(0) }
    var scoreTeamB by remember { mutableIntStateOf(0) }
    Box(modifier = Modifier.fillMaxSize() ){
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Coluna do Time 1
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Gray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "TIME - A",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(width = 200.dp, height = 200.dp)
                            .padding(8.dp)
                            .background(
                                color = Color.Black,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "$scoreTeamA",
                            fontSize = 70.sp
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Button(
                            onClick = {
                                scoreTeamA++
                            },
                            modifier = Modifier
                                .size(
                                    width = 80.dp,
                                    height = 50.dp
                                )
                                .background(
                                    color = Color.Black,
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            ),
                        ) {
                            Text(
                                "+",
                                fontSize = 25.sp,
                                color = Color.Gray
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                        )
                        Button(
                            onClick = {
                                if (scoreTeamA > 0) scoreTeamA--
                            },
                            modifier = Modifier
                                .size(
                                    width = 80.dp,
                                    height = 50.dp
                                )
                                .background(
                                    color = Color.Black,
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            ),
                        ) {
                            Text(
                                "-",
                                fontSize = 25.sp,
                                color = Color.Gray
                            )
                        }
                    }

                }
                // Coluna do Time 2
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Black),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "TIME - B",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(width = 200.dp, height = 200.dp)
                            .padding(8.dp)
                            .background(
                                color = Color.Gray,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(
                            text = "$scoreTeamB",
                            fontSize = 70.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                scoreTeamB++
                            },
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            modifier = Modifier
                                .size(
                                    width = 80.dp,
                                    height = 50.dp
                                )
                                .background(
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Text(
                                "+",
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                        }
                        Button(
                            modifier = Modifier
                                .size(
                                    width = 80.dp,
                                    height = 50.dp
                                )
                                .background
                                    (
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            onClick = { if (scoreTeamB > 0) scoreTeamB-- }) {
                            Text(
                                "-",
                                fontSize = 25.sp,
                                color = Color.Black

                            )
                        }
                    }

                }
            }

            // Botão de Reiniciar
            Button(
                onClick = {
                    scoreTeamA = 0
                    scoreTeamB = 0
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text("REINICIAR PARTIDA")
            }
        }
    }


}
@Preview
@Composable
fun ScoreBoardPreview(){
    ScoreboardApp()
}