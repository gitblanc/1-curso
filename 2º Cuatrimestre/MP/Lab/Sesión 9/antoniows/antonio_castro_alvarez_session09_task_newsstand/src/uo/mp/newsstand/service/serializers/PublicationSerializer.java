package uo.mp.newsstand.service.serializers;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;
import uo.mp.newsstand.domain.Publication;

public class PublicationSerializer {

	public List<String> serialize(List<Publication> publications) {
		List<String> res = new LinkedList<>();
		for(Publication p: publications) {
			res.add( p.serialize() );
		}
		return res;
	}

}
