/**
 * Interfejs repozytorium dla encji Danie.
 */
package com.catering.cateringapp.repository;

import com.catering.cateringapp.model.Danie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfejs repozytorium dla encji Danie.
 * Rozszerza JpaRepository, który zapewnia dodatkowe metody zapytań dla encji Danie.
 */
public interface DanieRepository extends JpaRepository<Danie, Long> {
}
