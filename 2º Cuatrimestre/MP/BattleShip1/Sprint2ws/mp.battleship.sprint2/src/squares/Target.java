/**
 * 
 */
package squares;

/**
 * @author blanc
 *
 */
public interface Target {

	int shootAt();
	boolean hasImpact();
	char toChar();
	char toFiredChar();
}
