package netlife.devmasters.booking.service.Impl;

import netlife.devmasters.booking.domain.RolUser;
import netlife.devmasters.booking.exception.domain.DataException;
import netlife.devmasters.booking.repository.RolUsuarioRepository;
import netlife.devmasters.booking.service.RolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolUserImpl implements RolUserService {

	private RolUsuarioRepository rolUsuarioRepository;

	@Autowired
	public RolUserImpl(RolUsuarioRepository rolUsuarioRepository) {
		this.rolUsuarioRepository = rolUsuarioRepository;
	}

	@Override
	public List<RolUser> getAll() {
		return this.rolUsuarioRepository.findAll();
	}

	@Override
	public List<RolUser> getAllByUsuario(Long codUsuario) {
		return this.rolUsuarioRepository.findByCodUsuario(codUsuario);
	}

	@Override
	public List<RolUser> getAllByRol(Long codRol) {
		return this.rolUsuarioRepository.findByCodRol(codRol);
	}

	@Override
	public RolUser save(RolUser obj) throws DataException {
		return this.rolUsuarioRepository.save(obj);
	}

	@Override
	public RolUser update(RolUser objActualizado) throws DataException {
		return this.save(objActualizado);
	}

	@Override
	public void delete(RolUser rolUsuario) throws DataException {
		Optional<RolUser> ru = this.rolUsuarioRepository.findById(rolUsuario.getRolUserId());
		if (ru.isPresent()) {
			this.rolUsuarioRepository.delete(ru.get());
		}

	}

	@Override
	public void deleteAllByRolUserId_codUsuario(Long codUsuario) {
		this.rolUsuarioRepository.deleteAllByRolUserId_IdUser(codUsuario);

	}

	@Override
	public List<RolUser> saveAll(Iterable<RolUser> entities) {
		return this.rolUsuarioRepository.saveAll(entities);
	}

	@Override
	public void deleteAndSave(Iterable<RolUser> entities, Long codUsuario) {

		// si hay elementos en la lista, eliminar todas las entidades asociadas al
		// usuario
		if (entities != null && entities.iterator().hasNext()) {
			RolUser mr = entities.iterator().next();

			this.deleteAllByRolUserId_codUsuario(mr.getRolUserId().getIdUser());

			// luego, registrar la configuración recibida en la lista
			this.saveAll(entities);

		}
		// si la lista está vacía, solo elimina los roles
		else {
			this.deleteAllByRolUserId_codUsuario(codUsuario);
		}

	}

}
