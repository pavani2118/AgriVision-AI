# API Design

## Authentication

| Method | Endpoint |
|--------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |
| GET | /api/auth/profile |

---

## Farm

| Method | Endpoint |
|--------|----------|
| POST | /api/farms |
| GET | /api/farms |
| GET | /api/farms/{id} |
| PUT | /api/farms/{id} |
| DELETE | /api/farms/{id} |

---

## Prediction

| Method | Endpoint |
|--------|----------|
| POST | /api/predictions |
| GET | /api/predictions/history |

---

## Disease

| Method | Endpoint |
|--------|----------|
| GET | /api/diseases |
| GET | /api/diseases/{id} |

---

## Weather

| Method | Endpoint |
|--------|----------|
| GET | /api/weather |