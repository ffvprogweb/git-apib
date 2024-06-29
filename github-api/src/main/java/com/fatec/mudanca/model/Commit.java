package com.fatec.mudanca.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @JsonProperty("commit")
    private CommitDetails commitDetails;

    public CommitDetails getCommitDetails() {
        return commitDetails;
    }

    public void setCommitDetails(CommitDetails commitDetails) {
        this.commitDetails = commitDetails;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CommitDetails {
        @JsonProperty("message")
        private String message;

        @JsonProperty("author")
        private Author author;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Author {
            @JsonProperty("date")
            private String date;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
