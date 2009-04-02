package schedule.utility;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/** Modello arraylist x la combobox
 * 
 */
public class ArrayListComboBoxModel extends AbstractListModel implements ComboBoxModel {
  private Object selectedItem;

  private ArrayList anArrayList;

  /**Costruttore
   * 
   * @param arrayList
   */
  public ArrayListComboBoxModel(ArrayList arrayList) {
    anArrayList = arrayList;
  }

  /**restituisce l'oggetto selezionato
   * 
   * @return selecteditem
   */
  public Object getSelectedItem() {
    return selectedItem;
  }

  /**imposta l'oggetto selezionato
   * 
   * @param newValue
   */
  public void setSelectedItem(Object newValue) {
    selectedItem = newValue;
  }

  /**restituisce la dimensione dell'arraylist
   * 
   * @return dimensione
   */
  public int getSize() {
    return anArrayList.size();
  }

  /**restituisce l'elemento alla posizione "i"
   * 
   * @param i posizione
   * @return elemento
   */
  public Object getElementAt(int i) {
    return anArrayList.get(i);
  }
} //end class
