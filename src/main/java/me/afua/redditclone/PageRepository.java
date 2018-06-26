package me.afua.redditclone;

import org.springframework.data.repository.CrudRepository;

public interface PageRepository extends CrudRepository<Page, Long> {
    Iterable <Page> findAllByOrderBySubmittedDesc();
}
