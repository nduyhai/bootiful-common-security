package com.bootiful.common.security;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("T(com.bootiful.common.security.OauthSecurityExpression).isUser()")
public @interface SecuredWithUser {}
