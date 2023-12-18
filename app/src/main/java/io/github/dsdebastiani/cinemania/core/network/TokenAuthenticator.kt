package io.github.dsdebastiani.cinemania.core.network

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(
    private val token: String
) : Authenticator {

    companion object {
        const val HEADER_AUTHORIZATION = "Authorization"
        const val AUTHORIZATION_TOKEN_TYPE = "Bearer"
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val token = "$AUTHORIZATION_TOKEN_TYPE $token"
        return response.request.newBuilder()
            .header(HEADER_AUTHORIZATION, token)
            .build()
    }
}
