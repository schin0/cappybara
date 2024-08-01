package br.com.invocoders.cappybara.screens.telalogin

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.LogoComponent
import br.com.invocoders.cappybara.data.api.LoginRetrofitFactory
import br.com.invocoders.cappybara.data.model.AuthResponse
import br.com.invocoders.cappybara.data.model.LoginRequest
import br.com.invocoders.cappybara.viewmodel.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController){
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    var rememberMe by remember { mutableStateOf(false) }


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 15.dp, end = 15.dp),
    ) {
        LogoComponent()
        Column {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 24.sp,
                    // TODO: Adicionar font roboto do google
                    //fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF120D26),
                )
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        Column {
            TextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp), // Ajuste a altura conforme necessário
                placeholder = { "Buscar..." },
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24), // Substitua com o seu ícone
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Email")
                    }
                },

                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )

            )
            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                value = senha.value,
                onValueChange = {
                    senha.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = { "Buscar..." },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_password_24), // Substitua com o seu ícone
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Senha")
                    }
                },
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                    )

            )
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Row(modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(
                        text = "Lembrar-me",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 23.sp,
                            // TODO: Adicionar font google
                            //fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF120D26),

                            textAlign = TextAlign.Right,
                        )
                    )
                }
                Row {
                    TextButton(onClick = { rememberMe = !rememberMe }) {
                        Text("Esqueceu a Senha?")
                    }
                }

            }

        }
        Button(
            onClick = {
                val call = LoginRetrofitFactory()
                    .loginRepository()
                    .loginRequest(
                        LoginRequest(email = email.value, senha = senha.value)
                    )


                call.enqueue(object : Callback<AuthResponse> {
                    override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                        Log.i("fiap", "${response.headers()}")
                    }

                    override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                        Log.i("fiap", "${t.message}")
                    }
                })
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5669FF)
            )
        ) {
            Text(text = "Entrar",
                color = Color.White,
                )
        }

       /* when (loginState) {
            is Result.Success -> {
                val token = (loginState as Result.Success<String>).getOrNull()
                // Sucesso no login, navegue para outra tela
                navController.navigate("home_screen")
            }
            is Result.Failure -> {
                // Exibir mensagem de erro
                Text(text = "Erro: ${(loginState as Result.Failure).exceptionOrNull()?.message}")
            }
            else -> {
                // Estado inicial ou em andamento
            }
        }*/

    }
}
/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewLogoComponent() {

    LoginScreen()
}*/