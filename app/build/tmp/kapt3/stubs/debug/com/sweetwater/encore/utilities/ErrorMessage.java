package com.sweetwater.encore.utilities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0001\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "CustomErrorMessage", "EmptyEmployeeNumberInputError", "InvalidInput", "LoginErrorBasic", "LogoutErrorBasic", "ServerError", "UserNotFoundInDbError", "Lcom/sweetwater/encore/utilities/ErrorMessage$CustomErrorMessage;", "Lcom/sweetwater/encore/utilities/ErrorMessage$EmptyEmployeeNumberInputError;", "Lcom/sweetwater/encore/utilities/ErrorMessage$InvalidInput;", "Lcom/sweetwater/encore/utilities/ErrorMessage$LoginErrorBasic;", "Lcom/sweetwater/encore/utilities/ErrorMessage$LogoutErrorBasic;", "Lcom/sweetwater/encore/utilities/ErrorMessage$ServerError;", "Lcom/sweetwater/encore/utilities/ErrorMessage$UserNotFoundInDbError;", "app_debug"})
public abstract class ErrorMessage {
    @org.jetbrains.annotations.NotNull
    private java.lang.String message;
    
    private ErrorMessage(java.lang.String message) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$InvalidInput;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "invalidInputMessage", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class InvalidInput extends com.sweetwater.encore.utilities.ErrorMessage {
        
        public InvalidInput(@org.jetbrains.annotations.NotNull
        java.lang.String invalidInputMessage) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$LoginErrorBasic;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "loginErrorBasicMessage", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class LoginErrorBasic extends com.sweetwater.encore.utilities.ErrorMessage {
        
        public LoginErrorBasic(@org.jetbrains.annotations.NotNull
        java.lang.String loginErrorBasicMessage) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$LogoutErrorBasic;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "logoutErrorBasicMessage", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class LogoutErrorBasic extends com.sweetwater.encore.utilities.ErrorMessage {
        
        public LogoutErrorBasic(@org.jetbrains.annotations.NotNull
        java.lang.String logoutErrorBasicMessage) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$UserNotFoundInDbError;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "userNotFoundInDbErrorMessage", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class UserNotFoundInDbError extends com.sweetwater.encore.utilities.ErrorMessage {
        
        public UserNotFoundInDbError(@org.jetbrains.annotations.NotNull
        java.lang.String userNotFoundInDbErrorMessage) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$EmptyEmployeeNumberInputError;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "emptyEmployeeNumberInputErrorMessage", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class EmptyEmployeeNumberInputError extends com.sweetwater.encore.utilities.ErrorMessage {
        
        public EmptyEmployeeNumberInputError(@org.jetbrains.annotations.NotNull
        java.lang.String emptyEmployeeNumberInputErrorMessage) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$ServerError;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "serverErrorMessage", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class ServerError extends com.sweetwater.encore.utilities.ErrorMessage {
        
        public ServerError(@org.jetbrains.annotations.NotNull
        java.lang.String serverErrorMessage) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/sweetwater/encore/utilities/ErrorMessage$CustomErrorMessage;", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "errorCode", "", "customMessage", "", "(ILjava/lang/String;)V", "getCustomMessage", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
    public static final class CustomErrorMessage extends com.sweetwater.encore.utilities.ErrorMessage {
        private final int errorCode = 0;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String customMessage = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.utilities.ErrorMessage.CustomErrorMessage copy(int errorCode, @org.jetbrains.annotations.NotNull
        java.lang.String customMessage) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public CustomErrorMessage(int errorCode, @org.jetbrains.annotations.NotNull
        java.lang.String customMessage) {
            super(null);
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getErrorCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCustomMessage() {
            return null;
        }
    }
}