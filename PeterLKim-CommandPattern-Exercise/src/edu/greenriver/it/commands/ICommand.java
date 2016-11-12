package edu.greenriver.it.commands;

/**
 * Created by peter on 11/11/2016.
 */
public interface ICommand {
    //perform the action...
    public void execute();

    public void unexecute();
}
