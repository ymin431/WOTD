package com.apptive.wotd.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apptive.wotd.R
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onLoginSuccess: () -> Unit = {}
) {
    val uiState by loginViewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is LoginUiState.Success) {
            onLoginSuccess()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "로그인",
            style = MaterialTheme.typography.titleMedium.copy(fontFamily = FontFamily(Font(R.font.pretendard_medium))),
        )

        Spacer(modifier = Modifier.weight(1f))

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "WELCOME!",
                fontSize = 32.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "3초만에 시작해보세요!",
                fontSize = 16.sp,
                color = Color.Gray,
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Button(
                onClick = { loginViewModel.onKakaoLoginClicked() },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFEE500),
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.kakao),
                        contentDescription = "카카오",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "카카오로 시작하기",
                        fontFamily = FontFamily(Font(R.font.pretendard_medium))
                    )

                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            OutlinedButton (
                onClick = { loginViewModel.onGoogleLoginClicked() },
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Google로 시작하기",
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.pretendard_medium))
                    )

                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}