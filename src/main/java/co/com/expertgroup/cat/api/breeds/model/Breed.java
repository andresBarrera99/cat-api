package co.com.expertgroup.cat.api.breeds.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Breed implements Serializable {

	private Weight weight;
	private String id;
	private String name;
	private String cfaUrl;
	private String vetstreetUrl;
	private String vcahospitalsUrl;
	private String temperament;
	private String origin;
	private String countryCodes;
	private String countryCode;
	private String description;
	private String lifeSpan;
	private Integer indoor;
	private Integer lap;
	private String altNames;
	private Integer adaptability;
	private Integer affectionLevel;
	private Integer childFriendly;
	private Integer dogFriendly;
	private Integer energyLevel;
	private Integer grooming;
	private Integer healthIssues;
	private Integer intelligence;
	private Integer sheddingLevel;
	private Integer socialNeeds;
	private Integer strangerFriendly;
	private Integer vocalisation;
	private Integer experimental;
	private Integer hairless;
	private Integer natural;
	private Integer rare;
	private Integer rex;
	private Integer suppressedTail;
	private Integer shortLegs;
	private String wikipediaUrl;
	private Integer hypoallergenic;
	private String referenceImageId;
	private Image image;
}
