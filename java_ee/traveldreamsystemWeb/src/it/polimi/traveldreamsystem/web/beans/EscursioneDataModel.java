package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class EscursioneDataModel extends ListDataModel<EscursioneDTO> implements SelectableDataModel<EscursioneDTO> {  

    public EscursioneDataModel() {
    }

    public EscursioneDataModel(List<EscursioneDTO> data) {
        super(data);
    }
    
    @Override
    public EscursioneDTO getRowData(String rowKey) {
        
        List<EscursioneDTO> cars = (List<EscursioneDTO>) getWrappedData();
        
        for(EscursioneDTO car : cars) {
            if(String.valueOf(car.getIdProdBase()).equals(rowKey));
                return car;
        }
        
        return null;
    }

    @Override
    public Object getRowKey(EscursioneDTO car) {
        return String.valueOf(car.getIdProdBase());
    }
}