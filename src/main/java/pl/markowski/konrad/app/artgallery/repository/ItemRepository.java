package pl.markowski.konrad.app.artgallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.markowski.konrad.app.artgallery.repository.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
}
