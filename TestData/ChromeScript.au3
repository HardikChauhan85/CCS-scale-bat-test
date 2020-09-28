WinWaitActive("","Chrome Legacy Window","120")
 If WinExists("","Chrome Legacy Window") Then
 Send("scaleadmin{TAB}")
 Send("sparkScaleAir#",1)
 Send("{Enter}")
 EndIf