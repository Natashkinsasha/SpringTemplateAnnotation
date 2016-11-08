package by.natashkinsasha.springtemplateannotation.repository;


import by.natashkinsasha.springtemplateannotation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long>{
}
