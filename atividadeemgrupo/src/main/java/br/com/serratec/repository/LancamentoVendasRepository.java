package br.com.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.entity.LancamentoVendas;


@Repository
public interface LancamentoVendasRepository extends JpaRepository<LancamentoVendas, Long> {
    Page<LancamentoVendas> findAll(Pageable pageable);
}