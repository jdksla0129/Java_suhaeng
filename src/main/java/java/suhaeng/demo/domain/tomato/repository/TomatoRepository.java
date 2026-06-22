package java.suhaeng.demo.domain.tomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.suhaeng.demo.domain.tomato.entity.Tomato;

@Repository
public interface TomatoRepository extends JpaRepository<Tomato, Long> {
}
