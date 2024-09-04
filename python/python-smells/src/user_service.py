from datetime import datetime, timedelta
from typing import List, Optional


class User:
    def __init__(self, user_id: int, full_name: str, date_of_birth: datetime):
        self.id = user_id
        self.full_name = full_name
        self.date_of_birth = date_of_birth

    def get_id(self) -> int:
        return self.id

    def get_date_of_birth(self) -> datetime:
        return self.date_of_birth


class UserService:
    def __init__(self):
        self.users: List[User] = []

    def add_user(self, full_name: str, date_of_birth: datetime) -> User:
        new_user = User(len(self.users) + 1, full_name, date_of_birth)
        self.users.append(new_user)
        return new_user

    def get_user_no(self) -> int:
        return len(self.users)

    def get_user_by_id(self, user_id: int) -> Optional[User]:
        for current_user in self.users:
            if current_user.get_id() == user_id:
                return current_user
        return None

    def is_adult(self, user_id: int) -> bool:
        current_user = self.get_user_by_id(user_id)
        if not current_user:
            return False
        return (datetime.now() - current_user.get_date_of_birth()).days >= 18 * 365


if __name__ == "__main__":
    service = UserService()
    user = service.add_user("John Doe", datetime(2007, 1, 1))
    print(f"Total users: {service.get_user_no()}")
    print(f"Is user adult? {service.is_adult(user.get_id())}")
