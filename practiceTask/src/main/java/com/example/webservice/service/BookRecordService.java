package com.example.webservice.service;

import com.example.webservice.model.BookRecord;
import com.example.webservice.repository.BookRecordJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookRecordService {
    private final BookRecordJpaRepository bookRecordJpaRepository;
    public Optional<BookRecord> addRecord(BookRecord bookRecord) throws Exception {
        if (bookRecord == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (bookRecordJpaRepository.existsById(bookRecord.getBook_id())) throw new Exception("Такая запись существует");
        return Optional.of(bookRecordJpaRepository.save(bookRecord));
    }
    public Optional<BookRecord> updateRecord(Long id) {
        if (id == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        BookRecord bookRecord = bookRecordJpaRepository.getById(id);
        bookRecord.setBorrowed_at(currentLocalDateTime());
        bookRecord.setReleased_at(currentLocalDateTime().plusDays(5));
        return Optional.of(bookRecordJpaRepository.save(bookRecord));
    }
    public void deleteRecord(Long id) {
        if (id == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        bookRecordJpaRepository.deleteById(id);
    }
    public List<BookRecord> findAllFreeBookRecords() {
        return bookRecordJpaRepository.findFreeBooks();
    }
    private LocalDateTime currentLocalDateTime() {
        return LocalDateTime.now();
    }
}
