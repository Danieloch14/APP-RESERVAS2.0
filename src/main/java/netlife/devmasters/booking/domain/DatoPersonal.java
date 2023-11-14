package netlife.devmasters.booking.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;

@Entity
@Table(name = "personal_data")
@Data
//@SQLDelete(sql = "UPDATE {h-schema}id_personal_data SET estado = 'ELIMINADO' WHERE cod_datos_personales = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "estado <> 'ELIMINADO'")
public class DatoPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_personal_data")
	private Integer idPersonalData;
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "address")
	private String address;
	@Column(name = "cellphone")
	private String cellphone;
	@Column(name = "email")
	private String email;
	@Column(name = "company")
	private String company;
}

