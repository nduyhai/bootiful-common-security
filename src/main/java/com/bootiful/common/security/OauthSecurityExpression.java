package com.bootiful.common.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.util.ObjectUtils;

public final class OauthSecurityExpression {

  private OauthSecurityExpression() {}

  public boolean isClient() {
    final var authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof JwtAuthenticationToken) {
      final var clientId =
          ((JwtAuthenticationToken) authentication).getTokenAttributes().get("clientId");
      return !ObjectUtils.isEmpty(clientId);
    }
    return false;
  }

  public boolean isUser() {
    return !isClient();
  }
}
