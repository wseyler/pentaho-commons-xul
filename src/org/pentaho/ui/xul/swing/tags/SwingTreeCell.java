package org.pentaho.ui.xul.swing.tags;

import java.util.Vector;

import javax.swing.JLabel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pentaho.ui.xul.XulComponent;
import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.components.XulTreeCell;
import org.pentaho.ui.xul.swing.SwingElement;
import org.pentaho.ui.xul.dom.Element;

public class SwingTreeCell extends SwingElement implements XulTreeCell {

  private JLabel label;

  private Object value = null;

  private int index = 0;
  private static final Log logger = LogFactory.getLog(SwingTreeCell.class);

  public SwingTreeCell(Element self, XulComponent parent, XulDomContainer domContainer, String tagName) {
    super("treecell");
    label = new JLabel();
    managedObject = label;
  }

  public SwingTreeCell(XulComponent parent) {
    super("treecell");
    label = new JLabel();
    managedObject = label;
  }

  public void setSelectedIndex(int index) {
    logger.debug("swingTreeCell.setSelectedIndex("+index+")");
    this.index = index;
  }

  public int getSelectedIndex() {
    return index;
  }

  public String getLabel() {
    return label.getText();
  }

  public String getSrc() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getValue() {
    return value;
  }

  public boolean isEditable() {
    // TODO Auto-generated method stub
    return false;
  }

  public void setEditable(boolean edit) {
    // TODO Auto-generated method stub

  }

  public void setLabel(String label) {
    this.label.setText(label);
  }

  public void setSrc(String srcUrl) {
    // TODO Auto-generated method stub

  }

  public void setValue(Object value) {
    if (value instanceof String && ((String) value).indexOf(",") == -1) {
      //String and not a comma separated list
      this.value = Boolean.parseBoolean(((String) value));
    } else if (value instanceof String && ((String) value).indexOf(",") > -1) {
      //String and a comma separated list
      String[] list = ((String) value).split(",");
      Vector<String> vec = new Vector<String>();
      for (String item : list) {
        vec.add(item);
      }
      this.value = vec;

    } else if (value instanceof Boolean) {
      this.value = (Boolean) value;
    } else {
      this.value = value;
    }
  }
}
