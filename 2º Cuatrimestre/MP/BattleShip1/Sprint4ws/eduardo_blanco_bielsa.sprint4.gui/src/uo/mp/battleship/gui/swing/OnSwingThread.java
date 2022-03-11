package uo.mp.battleship.gui.swing;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Target;

@Target({ TYPE, METHOD })
/**
 * Indicates that the type of method must be executed by the EDT 
 * (Event Dispatch Thread) of Swing
 * 
 * @author alb@uniovi.es
 */
public @interface OnSwingThread {

}
