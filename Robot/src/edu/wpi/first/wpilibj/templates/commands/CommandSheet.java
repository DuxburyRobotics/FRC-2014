/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Tate
 */
public class CommandSheet {
    private static CommandSheet instance = null;
    
    public AbsorbBallCommand absorbCommand;
    
    protected CommandSheet() {}
    
    public static CommandSheet getSheet() {
        if (instance == null)
            instance = new CommandSheet();
        
        return instance;
    }
    
    public void init() {
        absorbCommand = new AbsorbBallCommand();
    }
}