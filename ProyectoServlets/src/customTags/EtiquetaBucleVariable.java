/**
 * 
 */
package customTags;

/**
 * @author Alberto Vivas
 *
 * 
 */
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class EtiquetaBucleVariable extends SimpleTagSupport{
	
	
	private int num;
	
	
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();
		for (int i=0; i<num; i++) {
			pc.getRequest().setAttribute("count", String.valueOf( i + 1 ));
            //getJspContext().setAttribute("count", String.valueOf( i + 1 ) );
            getJspBody().invoke(null);
        }		
	}
 
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

	
	
}
