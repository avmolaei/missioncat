﻿#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

Up::Send go North {Enter}
Down::Send go South {Enter}
Left::Send go West {Enter}
Right:: Send go East {Enter}
PgUp:: Send go Up {Enter}


