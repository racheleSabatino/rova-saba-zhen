package it.polimi.traveldreamsystem.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@RequestScoped
public class MapBean {

		private MapModel simpleModel;

		public MapBean() {
			simpleModel = new DefaultMapModel();
			
			//Shared coordinates
			LatLng coord1 = new LatLng(45.478777, 9.232550);
			
			//Basic marker
			simpleModel.addOverlay(new Marker(coord1, "Agenzia Viaggi TravelDream, venite a trovarci al DEIB."));
		}

		public MapModel getSimpleModel() {
			return simpleModel;
		}
	}