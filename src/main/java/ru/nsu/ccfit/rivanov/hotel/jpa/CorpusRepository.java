package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.Corpus;

public interface  CorpusRepository extends JpaRepository<Corpus, Long> {
}
