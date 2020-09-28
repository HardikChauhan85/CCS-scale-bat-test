WinWaitActive("MozillaDialogClass","","120")
 If WinExists("MozillaDialogClass","") Then
 Send("scaleadmin{TAB}")
 Send("sparkScaleAir#",1)
 Send("{Enter}")
 EndIf