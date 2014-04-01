package utility;

import daointerfaces.EntryDAOInterface;
import innerStrings.ProgramStrings;
import models.Entry;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 18.07.13
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class EntryDataModel extends LazyDataModel<Entry> {

    private List<Entry> datasource;

    public List<Entry> getDatasource() {
        return datasource;
    }

    public EntryDataModel(List<Entry> datasource) {
        this.datasource = datasource;
        setRowCount(this.datasource.size());
    }


    public void setDatasource(List<Entry> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Entry getRowData(String rowKey){
        for(Entry entry : datasource) {
            if(String.valueOf(entry.getEntryId()).equals(rowKey))
                return entry;
        }
        return null;

    }

    @Override
    public Object getRowKey(Entry entry) {
        return entry.getEntryId();
    }

    @Override
    public void setRowIndex(int rowIndex) {
        /*
         * The following is in ancestor (LazyDataModel):
         * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        }
        else
            super.setRowIndex(rowIndex % getPageSize());
    }


    @Override
    public List<Entry> load(int i, int i2, String s, SortOrder sortOrder, Map<String, String> stringStringMap)  {

        EntryDAOInterface<Entry> dao = null;
        try {
            Context c = new InitialContext();
            String jndi = ProgramStrings.getProgramString("JNDIEntryDAO");
            dao = (EntryDAOInterface<Entry>) c.lookup(jndi);
        } catch (NamingException e) {
            e.printStackTrace();
        }
          datasource = dao.findAll(i,i+i2);
      // LinkedList<Entry>  result = new LinkedList<Entry>();
        long count = dao.count();
        this.setRowCount((int) count);
        sortOrder = SortOrder.DESCENDING;
        return datasource;
    }
}
