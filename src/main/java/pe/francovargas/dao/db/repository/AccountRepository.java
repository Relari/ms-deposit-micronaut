package pe.francovargas.dao.db.repository;


import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import pe.francovargas.dao.db.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Integer> {

}
