package pl.markowski.konrad.app.artgallery.service;

import org.springframework.stereotype.Service;
import pl.markowski.konrad.app.artgallery.repository.AuthorRepository;
import pl.markowski.konrad.app.artgallery.repository.entity.AuthorEntity;
import pl.markowski.konrad.app.artgallery.web.model.AuthorModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AuthorService {
    private static final Logger LOGGER = Logger.getLogger(AuthorService.class.getName());

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // C - create
    public void create(AuthorModel authorModel) {
        LOGGER.info("create(" + authorModel + ")");
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName(authorModel.getFirstName());
        authorEntity.setLastName(authorModel.getLastName());
        authorEntity.setName(authorModel.getName());
        authorEntity.setPassword(authorModel.getPassword());
        authorRepository.save(authorEntity);
    }

    // R - read
    public AuthorEntity read(Long id) throws Exception {
        LOGGER.info("read(" + id + ")");
        Optional<AuthorEntity> optionalAuthorEntity = authorRepository.findById(id);
        AuthorEntity authorEntity = optionalAuthorEntity.orElseThrow(
                () -> new Exception("nie znaleziono autora o id: " + id));
        LOGGER.info("read(...) =  " + authorEntity);
        return authorEntity;
    }

    // U - update
    public void update(AuthorModel authorModel) throws Exception {
        LOGGER.info("update(" + authorModel + ")");
        Optional<AuthorEntity> optionalAuthorEntity = authorRepository.findById(authorModel.getId());
        AuthorEntity authorEntity = optionalAuthorEntity.orElseThrow(
                () -> new Exception("nie znaleziono autora o id: " + authorModel.getId()));
        authorEntity.setFirstName(authorModel.getFirstName());
        authorEntity.setLastName(authorModel.getLastName());
        authorEntity.setName(authorModel.getName());
        authorEntity.setPassword(authorModel.getPassword());
        authorRepository.save(authorEntity);
    }
    // D - delete
    public void delete(Long id) throws Exception {
        Optional<AuthorEntity> optionalAuthorEntity = authorRepository.findById(id);
        AuthorEntity authorEntity = optionalAuthorEntity.orElseThrow(
                () -> new Exception("nie znaleziono autora o id: " + id));
        authorRepository.delete(authorEntity);
    }
    // L - list
    public List<AuthorEntity> list() {
       return authorRepository.findAll();
    }
}
