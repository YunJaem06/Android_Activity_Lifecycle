package com.example.android_activity_lifecycle

data class UserInfo(
    var userID: String,
    var userPW: String,
    var userName: String,
)

val UserInfoList = mutableListOf<UserInfo>(
    UserInfo(
        userID = "viva1@naver.com",
        userPW = "1111",
        userName = "비바1",
    ),
    UserInfo(
        userID = "viva2@naver.com",
        userPW = "2222",
        userName = "비바2",
    ),
    UserInfo(
        userID = "viva3@naver.com",
        userPW = "3333",
        userName = "비바3",
    ),
)
