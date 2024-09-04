import unittest
from src.user_service import *


class UserServiceTest(unittest.TestCase):
    # DETECTED - constructor initialization
    """
    def __init__(self):
        super().__init__()
        self.user_service = UserService()
        self.user = self.user_service.add_user("USER 1", datetime(2003, 6, 29))
    """

    # NOT DETECTED - magic number
    def setUp(self):
        self.user_service = UserService()
        self.user1 = self.user_service.add_user("USER 1", datetime(2003, 6, 29))
        self.user2 = self.user_service.add_user("USER 2", datetime(2010, 6, 28))
        self.user3 = self.user_service.add_user("USER 3", datetime(2003, 6, 29))

    # NOT DETECTED - assertion roulette (disabled by default)
    def test_adult(self):
        self.assertTrue(self.user_service.is_adult(self.user1.get_id()))
        self.assertFalse(self.user_service.is_adult(self.user2.get_id()))

    # DETECTED - empty test
    def test_empty(self):
        pass

    # DETECTED - suboptimal assert
    def test_suboptimal_assert(self):
        self.assertEqual(self.user_service.is_adult(self.user1.get_id()), True)

    # DETECTED - redundant assertion
    def test_redundant_assert(self):
        self.assertEqual(1, 1)

    def test_duplicate_assert(self):
        self.assertTrue(self.user_service.is_adult(self.user1.get_id()))
        self.assertTrue(self.user_service.is_adult(self.user1.get_id()))


if __name__ == '__main__':
    unittest.main()
