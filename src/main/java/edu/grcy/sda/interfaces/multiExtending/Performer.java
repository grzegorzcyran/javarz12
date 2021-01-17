package edu.grcy.sda.interfaces.multiExtending;

/**
 * interfejs, w przeciwieństwie do klasy
 * może rozszerzać więcej niż jeden interfejs
 */
public interface Performer extends Worker, Trainer {
    void perform();
}
