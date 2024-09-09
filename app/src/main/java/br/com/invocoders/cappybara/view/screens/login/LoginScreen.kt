package br.com.invocoders.cappybara.view.screens.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.BuildConfig
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.services.LoginService
import br.com.invocoders.cappybara.view.components.login.LogoComponent
import br.com.invocoders.cappybara.viewmodel.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun LoginScreen(
    navController: NavController,
    contexto: Context,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
    )
) {
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    var rememberMe by remember { mutableStateOf(false) }
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))
    val token = BuildConfig.TOKEN_FIREBASE
    val context = LocalContext.current

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)

            try {
                val account = task.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)

                viewModel.signInWithGoogleCredential(credential) {
                    redirecionarParaHome(navController)
                }
            } catch (ex: Exception) {
                Log.d("Autenticacao", "Falhou")
            }
        }

    Column(
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
                    fontFamily = roboto,
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
                    .height(65.dp),
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24_white),
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
                    .height(65.dp),
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_password_24_white),
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(
                        text = "Lembrar-me",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 23.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF120D26),

                            textAlign = TextAlign.Right,
                        )
                    )
                }
                Row {
                    TextButton(onClick = { rememberMe = !rememberMe }) {
                        Text("Esqueceu a Senha?", color = Color.Black)
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    LoginService().logar(
                        email.value,
                        senha.value,
                        { redirecionarParaHome(navController) },
                        { mostrarMensagemErro(contexto) }
                    )
                },
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = Color(0x154AD2E4),
                        ambientColor = Color.Black
                    )
                    .width(273.dp)
                    .height(56.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5669FF),
                    contentColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Entrar",
                        color = Color.White,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ou",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 34.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF9D9898),
                    textAlign = TextAlign.Center,
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    val opcoes = GoogleSignInOptions.Builder(
                        GoogleSignInOptions.DEFAULT_SIGN_IN
                    ).requestIdToken(token)
                        .requestEmail().build()

                    val googleSignInClient = GoogleSignIn.getClient(context, opcoes)
                    launcher.launch(googleSignInClient.signInIntent)
                },
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = Color(0x154AD2E4),
                        ambientColor = Color.Black
                    )
                    .width(273.dp)
                    .height(56.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(size = 12.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        Modifier
                            .width(26.dp)
                            .height(26.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Login com o Google",
                        color = Color.Black,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Ainda não possui uma conta? ", color = Color.Black)
            Text(
                text = "Cadastre-se",
                color = Color(0xFFFD3A84),
                modifier = Modifier
                    .clickable { navController.navigate("cadastroUsuario") }
            )
        }

    }
}

fun redirecionarParaHome(navController: NavController) {
    navController.navigate("home")
}

fun mostrarMensagemErro(contexto: Context) {
    Toast.makeText(contexto, "Usuário ou senha errados!", Toast.LENGTH_SHORT).show()
}