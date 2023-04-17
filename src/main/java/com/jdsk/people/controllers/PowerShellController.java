package com.jdsk.people.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdsk.people.Integrations.powershell.config.PowerShellWebSocketHandler;

@RestController
@RequestMapping("/powershell")
public class PowerShellController {
    @Autowired
    private PowerShellWebSocketHandler powerShellWebSocketHandler;
    
}
