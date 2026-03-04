package com.moviereservation.cinema;

import java.util.List;

import com.moviereservation.theater.BETheater;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cinemas", indexes = {
		@Index(name = "idx_cinema_sublocality", columnList = "sublocality")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BECinema { 
	//Para hacerte recordar. El locality = departamento o sea no puedes guardar departamentos que no existan. Ahi lo ves tu!
	//Recuerda de terminar los Services de todos las entidades y ya podrás pasar a controller
	//OJO NUNCA PONGAS NINGUN DATO SENSIBLE EN application.properties QUE LUEGO LO VAS A SUBIR A GITHUB
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
    private String locality;

    @Column(nullable = false, length = 50)
    private String sublocality;

    @Column(nullable = false, length = 250)
    private String address;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<BETheater> theaters;
}
