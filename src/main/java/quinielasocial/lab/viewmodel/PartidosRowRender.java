package quinielasocial.lab.viewmodel;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;
public class PartidosRowRender implements RowRenderer {
	public void render(final Row row, final java.lang.Object data) {
        String[] ary = (String[]) data;
        new Label(ary[0]).setParent(row);
        new Label(ary[1]).setParent(row);
        new Label(ary[2]).setParent(row);
        new Label(ary[3]).setParent(row);
    }
    /**
    /* added by aaknai for compatibility with zk 6.5.2
     */
    public void render(final Row row, final java.lang.Object data, int index) {
        render(row,data);
    }
	
}
