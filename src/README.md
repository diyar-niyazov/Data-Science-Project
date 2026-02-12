# TODO Improvements for Video Game Sales Project

---

## Main

**Improve:**
- Accept filename from `args` instead of hardcoding.
- Add guard for empty CSV before accessing `list.get(0)`.
- Remove manual `ArrayList → double[][]` conversion.
- Let `CorrelationCalculator` return `double[][]` directly.
- Fix minor formatting inconsistencies.
- Do not print inside logic classes — keep `Main` as orchestrator only.

---

## CSV_Parser

**Improve:**
- Do NOT call `parseCSV()` inside constructor.
- Make `parseCSV()` private (or rename to `parse()` and call explicitly).
- Remove hardcoded `"assets"` path — accept full path.
- Do NOT return internal mutable `ArrayList`; return unmodifiable list.
- Replace `File + Scanner` with `Files.readAllLines(Path)` (modern Java).
- Make `removeInnerCommas()` private.
- Remove console printing inside catch block (throw or handle properly).

---

## Game

**Improve:**
- Replace all `Double` with primitive `double`.
- Remove stored `String[] values` (not needed after construction).
- Remove `printGame()` — override `toString()` instead.
- Remove console printing inside `parseDoubleField()`.
- Avoid duplicate `values[index]` lookup inside parsing.
- Keep model class pure — no I/O logic.

---

## GameList

**Improve:**
- Return unmodifiable collections from getters.
- Replace `HashMap` with `Map` in field declarations.
- Remove redundant switch in `getFrequency()`.
- Use `merge()` instead of `getOrDefault()` for incrementing.
- Initialize categorical maps dynamically using enum iteration.
- Remove `printMaps()` (belongs in display/debug layer).
- Do NOT return raw `ArrayList<Game>`; return `List<Game>`.

---

## CorrelationCalculator

**Improve:**
- Remove `BigDecimal` entirely.
- Use `double` everywhere.
- Use `double[][]` instead of `ArrayList<ArrayList<Double>>`.
- Compute only numeric categories (pre-filter once).
- Use symmetry: compute half matrix and mirror.
- Remove `sameValueAdded` flag.
- Add zero-denominator protection.
- Return unmodifiable result (or just return matrix safely).
- Make computation method private and clean.

---

## CorrelationCoefficient

**Improve:**
- Remove this class entirely.
- Move formula into `CorrelationCalculator` as private method.
- If kept, make method static.
- Remove stored state (`r`).
- Remove `BigDecimal`.
- Add zero-division guard.

---

## CSV_Category

**Improve:**
- Do NOT use `ordinal()` for index.
- Explicitly store index in constructor.
- Keep metadata (`numeric`) — that is good.
- No other changes needed.

---

## High-Level Structural Improvements

Implement these and your project becomes clean and near-professional:
- No printing inside model/data classes.
- No mutable internal state leaks.
- No unnecessary `BigDecimal`.
- No redundant abstraction.
- Use interfaces (`List`, `Map`) instead of implementations.
- Keep constructors lightweight (no heavy I/O).
- Keep matrix data in primitive arrays when numerical.

---

## Priority Order

1. Remove `BigDecimal` everywhere.
2. Convert correlation storage to `double[][]`.
3. Remove `CorrelationCoefficient` class.
4. Fix encapsulation leaks (`unmodifiableList`, etc.).
5. Replace `ordinal()` in enum.
6. Clean constructors and parsing.