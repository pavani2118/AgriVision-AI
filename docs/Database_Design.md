# Database Design

## User

| Field | Type |
|-------|------|
| id | UUID |
| full_name | String |
| email | String |
| password | String |
| role | String |
| phone | String |
| created_at | Timestamp |
| updated_at | Timestamp |

---

## Farm

| Field | Type |
|-------|------|
| id | UUID |
| user_id | UUID |
| farm_name | String |
| district | String |
| location | String |
| crop_type | String |
| farm_size | Double |
| created_at | Timestamp |

Relationship:

User (1) → Farm (Many)

---

## Disease

| Field | Type |
|-------|------|
| id | UUID |
| name | String |
| description | Text |
| symptoms | Text |
| treatment | Text |
| prevention | Text |
| image_url | String |

---

## Prediction

| Field | Type |
|-------|------|
| id | UUID |
| user_id | UUID |
| farm_id | UUID |
| disease_id | UUID |
| image_url | String |
| confidence | Double |
| prediction_date | Timestamp |

Relationship:

User → Prediction

Farm → Prediction

Disease → Prediction